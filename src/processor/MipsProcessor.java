package processor;

import gui.MipsMainFrame;
import gui.model.TableControlsModel;
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

public class MipsProcessor extends Observable{

	private ArrayList<Instruction> _instructionsToDo;
	private int _indexCurrentInstruction;
	private InstructionMemory _instructionMemory;
	private DataMemory _dataMemory;
	private ALU _alu;
	private ALUControl _aluControl;
	private PC _pc;
	private PCAddUnit _pcAddUnit;
	private Registers _registers;
	private Control _control;

	public MipsProcessor(ArrayList<Instruction> ins){
		_instructionsToDo = ins;
		_instructionMemory = new InstructionMemory();
		for(Instruction i : ins){
			if(!(i instanceof ExitInstruction)){
				_instructionMemory.addInstructionToMemory(i.getBinaryRepresentation());
			}
		}
		System.out.println(_instructionMemory.getInstruction(0));
		_registers = new Registers();
		_indexCurrentInstruction = -1;
		_control = new Control();
	}
	
	public Control getControls(){
		return _control;
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
	
	public Instruction getCurrentInstruction(){
		return _instructionsToDo.get(_indexCurrentInstruction);
	}

	public void execute(){
		if(_indexCurrentInstruction != -1){
			Instruction i = _instructionsToDo.get(_indexCurrentInstruction);
			i.execute(this);
		}
		_indexCurrentInstruction++;
		setChanged();
		notifyObservers();
	}
	
	public int getIndexCurrentInstruction(){
		return _indexCurrentInstruction;
	}
}
