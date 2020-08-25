public class Main {

	public static void main(String[] args) {
		
		RubikCube c = new RubikCube();

		double averageMoves = 0;
		for(int i=0; i < 10; i++){
			String s = RubikCube.generateScramble();		
			c.scramble(s);
			
			averageMoves+= c.Solve();	
		} 
		
		System.out.println("Average Moves: " + averageMoves/10);
		
	}
}
