package processor;

import gui.MipsMainFrame;
import gui.model.TableInstructionToDoModel;
import gui.model.TableRegisterModel;
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
		_registers = new Registers();
		_indexCurrentInstruction = -1;
	}

	public TableRegisterModel getRegistersTableModel(){
		return new TableRegisterModel(_registers);
	}

	public  TableInstructionToDoModel getInstructionToDoTableModel(){
		return new TableInstructionToDoModel(_instructionsToDo);
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
