package processor;

import gui.model.TableControlsModel;
import gui.model.TableDataMemoryModel;
import gui.model.TableInstructionToDoModel;
import gui.model.TableRegisterModel;
import instruction.ExitInstruction;
import instruction.Instruction;

import java.util.ArrayList;
import java.util.Observable;

import processor.alu.ALU;
import processor.alu.ALUControl;
import processor.controls.Control;
import processor.memory.DataMemory;
import processor.memory.InstructionMemory;
import processor.pc.PC;
import processor.pc.PCAddUnit;
import processor.register.Registers;
import processor.signextender.SignExtender;

public class MipsProcessor extends Observable{

	private boolean _hasFinished;
	private ArrayList<Instruction> _instructionsToDo;
	private InstructionMemory _instructionMemory;
	private DataMemory _dataMemory;
	private ALU _alu;
	private ALUControl _aluControl;
	private PC _pc;
	private PCAddUnit _pcAddUnit;
	private Registers _registers;
	private Control _control;
	private SignExtender _signExtender;

	public MipsProcessor(ArrayList<Instruction> ins){
		_instructionsToDo = ins;
		_instructionMemory = new InstructionMemory();
		for(Instruction i : ins){
			if(!(i instanceof ExitInstruction)){
				_instructionMemory.addInstructionToMemory(i.getBinaryRepresentation());
			}
		}
		_dataMemory = new DataMemory();
		_alu = new ALU();
		_aluControl = new ALUControl();
		_pc = new PC();
		_pcAddUnit = new PCAddUnit();
		_registers = new Registers();
		_control = new Control();
		_signExtender = new SignExtender();
		_hasFinished = false;
		setChanged();
	}

	public Control getControls(){
		return _control;
	}
	
	public Registers getRegisters(){
		return _registers;
	}
	
	public DataMemory getDataMemory(){
		return _dataMemory;
	}

	public TableRegisterModel getRegistersTableModel(){
		return new TableRegisterModel(_registers);
	}

	public  TableInstructionToDoModel getInstructionToDoTableModel(){
		return new TableInstructionToDoModel(_instructionsToDo);
	}

	public  TableControlsModel getControlsTableModel(){
		return new TableControlsModel(_control);
	}

	public TableDataMemoryModel getDataMemoryTableModel(){
		return new TableDataMemoryModel(_dataMemory);
	}

	public Instruction getCurrentInstruction(){
		return _instructionsToDo.get(_pc.getPCValue() / 4);
	}

	/**
	 * Execute the current instruction
	 */
	public void execute(){
		if(!(getCurrentInstruction() instanceof ExitInstruction)){
			int completeInstruction = _instructionMemory.getInstruction(_pc.getPCValue());
			_pcAddUnit.incrementPC(_pc);
			_control.setInputOpcode(completeInstruction);
			_control.activateLines();
			_registers.setInputReadRegister1(completeInstruction);
			_registers.setInputReadRegister2(completeInstruction);
			_registers.setInputWriteRegister(completeInstruction, _control);
			_registers.setOuputReadData1();
			_registers.setOuputReadData2();
			_signExtender.setInputInstruction(completeInstruction);
			_signExtender.setOutput();
			_aluControl.setInputAluOp0(_control);
			_aluControl.setInputAluOp1(_control);
			_aluControl.setInputFunctionCode(completeInstruction);
			_aluControl.setOutputOperation();
			_alu.setInputReadData1(_registers);
			_alu.setInputReadData2(_registers, _control, _signExtender);
			_alu.executeOperation(_aluControl);
			_pcAddUnit.branchPC(_signExtender.getOutput(), _control, _alu, _pc);
			_dataMemory.setInputMemRead(_control);
			_dataMemory.setInputMemWrite(_control);
			_dataMemory.setInputAddress(_alu);
			_dataMemory.setInputWriteData(_registers);
			_dataMemory.setOutputReadData();
			int out = _dataMemory.getOutput(_control, _alu);
			_registers.setInputWriteData(out);
			_registers.writeData(_control);
			setChanged();
			notifyObservers();
		}else{
			_hasFinished = true;
		}
	}
	
	public boolean hasFinised(){
		return _hasFinished;
	}

	public void reset(){
		_hasFinished = false;
		_registers.reset();
		_dataMemory.reset();
		_pc.reset();
		_control.reset();
		setChanged();
		notifyObservers();
	}

	public int getIndexCurrentInstruction(){
		return _pc.getPCValue() / 4;
	}

	public PC getPC(){
		return _pc;
	}
}
