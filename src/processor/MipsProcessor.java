package processor;

import gui.model.TableRegisterModel;
import processor.alu.ALU;
import processor.alu.ALUControl;
import processor.controls.Control;
import processor.memory.DataMemory;
import processor.memory.InstructionMemory;
import processor.pc.PC;
import processor.pc.PCAddUnit;
import processor.register.Registers;

public class MipsProcessor {

	private InstructionMemory _instructionMemory;
	private DataMemory _dataMemory;
	private ALU _alu;
	private ALUControl _aluControl;
	private PC _pc;
	private PCAddUnit _pcAddUnit;
	private Registers _registers;
	private Control _control;

	public MipsProcessor(){
		_registers = new Registers();
	}
	
	public TableRegisterModel getRegistersTableModel(){
		return new TableRegisterModel(_registers);
	}
}
