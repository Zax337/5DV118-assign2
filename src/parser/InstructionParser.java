/**
 * 
 */
package parser;

import instruction.ExitInstruction;
import instruction.Instruction;
import instruction.iformat.BeqInstruction;
import instruction.iformat.LwInstruction;
import instruction.iformat.SwInstruction;
import instruction.rformat.AddInstruction;
import instruction.rformat.AndInstruction;
import instruction.rformat.NopInstruction;
import instruction.rformat.NorInstruction;
import instruction.rformat.OrInstruction;
import instruction.rformat.SltInstruction;
import instruction.rformat.SubInstruction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Acid Flow
 *
 */
public class InstructionParser {

	private static HashMap<String, Class> INSTRUCTIONS = new HashMap<String, Class>();
	
	static{
		INSTRUCTIONS.put("add", AddInstruction.class);
		INSTRUCTIONS.put("sub", SubInstruction.class);
		INSTRUCTIONS.put("and", AndInstruction.class);
		INSTRUCTIONS.put("or", OrInstruction.class);
		INSTRUCTIONS.put("nor", NorInstruction.class);
		INSTRUCTIONS.put("slt", SltInstruction.class);
		INSTRUCTIONS.put("lw", LwInstruction.class);
		INSTRUCTIONS.put("sw", SwInstruction.class);
		INSTRUCTIONS.put("beq", BeqInstruction.class);
		INSTRUCTIONS.put("nop", NopInstruction.class);
		INSTRUCTIONS.put("exit", ExitInstruction.class);
	}
	
	public static ArrayList<Instruction> parseFile(String file){
		ArrayList<Instruction> instructionList = new ArrayList<Instruction>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String ins;
			while((ins = br.readLine()) != null){
				ins.trim();
				String[] insPart = ins.split(" ");
				if(INSTRUCTIONS.containsKey(insPart[0])){
					Instruction i = (Instruction) INSTRUCTIONS.get(insPart[0]).newInstance();
					i.setMnemonic(ins);
					i.generateBinaryRepresentation();
					instructionList.add(i);
				}
			}
			return instructionList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
