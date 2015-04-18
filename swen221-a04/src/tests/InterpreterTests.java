package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment4.shapes.Canvas;
import assignment4.shapes.Interpreter;



public class InterpreterTests {
	/**
	 * Some simple tests that the fill command is working. You will want to add
	 * more of your own tests!
	 */
	@Test public void validFillTests() {
		String[][] inputs = {
				{"x = [2,2,4,4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x= [2,2,4,4]\nfill x #010203\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#010203#010203#010203#010203\n#ffffff#ffffff#010203#010203#010203#010203\n#ffffff#ffffff#010203#010203#010203#010203\n#ffffff#ffffff#010203#010203#010203#010203\n"},
				{"x =[2,2,4,4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"fill [2,2,4,4] #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x=[2,2,4,4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x=[2 ,2,4,4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x=[2, 2,4,4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x=[2, 2, 4, 4]\nfill x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x    =  [2   , 2  , 4  , 4    ]\nfill   x     #0000ff  \n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"}
			};		
		testValidInputs(inputs);			
	}
	
	/**
	 * Some simple tests that the draw command is working. You will want to add
	 * more of your own tests!
	 */
	@Test public void validDrawTests() {
		String[][] inputs = {				
				{"x = [2,2,4,4]\ndraw x #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},
				{"x = [2,2,4,4]\ndraw x #010203\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#010203#010203#010203#010203\n#ffffff#ffffff#010203#ffffff#ffffff#010203\n#ffffff#ffffff#010203#ffffff#ffffff#010203\n#ffffff#ffffff#010203#010203#010203#010203\n"},
				{"draw [2,2,4,4] #010203\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#010203#010203#010203#010203\n#ffffff#ffffff#010203#ffffff#ffffff#010203\n#ffffff#ffffff#010203#ffffff#ffffff#010203\n#ffffff#ffffff#010203#010203#010203#010203\n"},
				{"x = [2,2,4,4]\ndraw x #0000ff\ny = [0,0,3,3]\ndraw y #010203\n","#010203#010203#010203#ffffff#ffffff#ffffff\n#010203#ffffff#010203#ffffff#ffffff#ffffff\n#010203#010203#010203#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"},				
				{" x = [ 2 , 2     , 4 , 4 ]\n     draw    x  #0000ff    \ny = [0,0,3,3]\ndraw y #010203\n","#010203#010203#010203#ffffff#ffffff#ffffff\n#010203#ffffff#010203#ffffff#ffffff#ffffff\n#010203#010203#010203#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"}				
		};
			
		testValidInputs(inputs);			
	}
	
	/**
	 * Some simple tests that shape union is working. You will want to add
	 * more of your own tests!
	 */
	@Test public void validUnionTests() {
		String[][] inputs = {			
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = y + x\ndraw y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},				
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = y+ x\ndraw y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = y +x\ndraw y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = y+x\ndraw y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = (y + x)\ndraw y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\nx = ([0,0,3,3] + x)\ndraw x #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\nx = ([0,0,3,3] + [2,2,4,4])\ndraw x #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#ffffff#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\ny = [0,0,3,3]\ny = y + x\nfill y #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
		};				
			
		testValidInputs(inputs);			
	}
	
	/**
	 * Some simple tests that shape intersection is working. You will want to add
	 * more of your own tests!
	 */
	@Test public void validIntersectionTests() {
		String[][] inputs = {
				{"x = [2,0,5,5]\ny = [0,2,4,4]\ndraw x #00ff00\ndraw y #0000ff\ny = y & x\ndraw y #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"},				
				{"x = [2,0,5,5]\ny = [0,2,4,4]\ndraw x #00ff00\ndraw y #0000ff\ny = y& x\ndraw y #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,4]\ndraw x #00ff00\ndraw y #0000ff\ny = y &x\ndraw y #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,4]\ndraw x #00ff00\ndraw y #0000ff\ny =y&x\ndraw y #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"},
				{"x = [2,0,5,5]\ndraw x #00ff00\nx = [0,2,4,4]\ndraw x #0000ff\nx =x&[2,0,5,5]\ndraw x #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,4]\ndraw x #00ff00\ndraw y #0000ff\ny = y & x\nfill y #ff0000","#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff#00ff00\n#0000ff#0000ff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#ffffff#ffffff#00ff00\n#0000ff#ffffff#ff0000#ff0000#00ff00#00ff00#00ff00\n#0000ff#0000ff#0000ff#0000ff#ffffff#ffffff#ffffff\n"}				
		};				
			
		testValidInputs(inputs);			
	}
	
	/**
	 * Some simple tests that shape difference is working. You will want to add
	 * more of your own tests!
	 */
	@Test public void validDifferenceTests() {
		String[][] inputs = {
				{"x = [2,0,5,5]\ny = [0,2,4,5]\ny = y - x\ndraw y #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ffffff#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"},				
				{"x = [2,0,5,5]\ny = [0,2,4,5]\ny = y- x\ndraw y #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ffffff#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,5]\ny = y -x\ndraw y #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ffffff#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,5]\ny =  y-x\ndraw y #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ffffff#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"},
				{"x = [2,0,5,5]\nx = [0,2,4,5]-x\ndraw x #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ffffff#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"},
				{"x = [2,0,5,5]\ny = [0,2,4,5]\ny =  y-x\nfill y #ff0000\n","#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ffffff#ffffff\n#ff0000#ff0000#ff0000#ff0000\n#ff0000#ff0000#ff0000#ff0000\n"}
		};				
			
		testValidInputs(inputs);			
	}
	
	/**
	 * Some additional test which should pass
	 */
	@Test public void additionalTests() {
		String[][] inputs = {
				// test for multiple operators and operands (3+)
				{"x = [2,2,4,4]\ny = [0,0,3,3]\nz = [3,0,6,3]\ny = y + x + z + x \ndraw y #00ff00\n","#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00\n#00ff00#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff#00ff00\n#00ff00#00ff00#ffffff#ffffff#ffffff#ffffff#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff\n#ffffff#ffffff#00ff00#ffffff#ffffff#00ff00#ffffff#ffffff#ffffff\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n"},
				// test for new variable from other two
				{"x = [2,2,4,4]\ny = [0,0,3,3]\nz = y + x\nfill z #00ff00\n","#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#00ff00#ffffff#ffffff#ffffff\n#00ff00#00ff00#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				// test with variable names longer than one char
				{"xa = [2,2,4,4]\nfill xa #00ff00\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n#ffffff#ffffff#00ff00#00ff00#00ff00#00ff00\n"},
				{"x = [2,2,4,4]\ny=x\ndraw y #0000ff\n","#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#ffffff#ffffff#ffffff#ffffff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#ffffff#ffffff#0000ff\n#ffffff#ffffff#0000ff#0000ff#0000ff#0000ff\n"}
		};				
			
		testValidInputs(inputs);			
	}


	@Test public void invalidSyntaxTests() {
		// This test makes sure that the interpreter throws an appropriate error message
		String[] inputs = {
				"x = [2,2,4,4]\nfill y #0000ff\n",
				"x = [2.012,2,4,4]\nfill x #0000ff\n",
				"x= [4,4,-2,2]\nfill x #010203\n",				
				"x= [4,4,-2,2]\nfill x\n",
				"x= [4,4,2,2]\ndraw z\n",
				"x = [2,0,5,5]\ny = [0,2,4,5]\ny =  y-z\nfill y #ff0000\n",
				"x = [2,0,5,5]\ny = [0,2,4,5]\ny =  (y-x\nfill y #ff0000\n",
				"x = [2,0,5]\nfill x #ff0000\n",
				"x += [2,0,5,5]\nfill x #ff0000\n",
			};		
				
		for(int i=0;i!=inputs.length;++i) {
			String input = inputs[i];
			try {
				new Interpreter(input).run();
				fail("Input " + i  + " should have given an error!");				
			} catch(IllegalArgumentException e) {
				// ok, this seems alright!
			} catch(Exception e) {
				fail("Exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}				
	}		
	
	private void testValidInputs(String[][] inputs) {
		for(int i=0;i!=inputs.length;++i) {
			String[] input = inputs[i];
			try {
				Canvas canvas = new Interpreter(input[0]).run();
				String output = canvas.toString();
//				System.out.println(input[1]);
				if(!input[1].equals(output)) {
//					System.out.println("RRRRR");
					System.out.println(output);
					fail("Incorrect output on input " + i + " : " + input[0]);
				}
			} catch(Exception e) {
				fail("Exception occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}	
}
