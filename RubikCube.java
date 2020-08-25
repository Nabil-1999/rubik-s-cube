import java.util.Random;

public class RubikCube extends FaceCreate{
	FaceCreate Up, Down, Left, Right, Back, Front;
	int numberOfTurns = 0;

	public RubikCube(){ 
		this.Up = new FaceCreate('W');
		this.Down = new FaceCreate('Y');
		this.Left = new FaceCreate('O');
		this.Right = new FaceCreate('R');
		this.Front = new FaceCreate('G');
		this.Back = new FaceCreate('B');
	}

	public void print(){

		
		for(int i=0; i<2; i++){
			System.out.println("   " + Up.face[i][0] + Up.face[i][1]);
		}
		System.out.println("");

		

		for(int i=0; i<2; i++){
			System.out.println("" + Left.face[i][0] + Left.face[i][1] + " " +
					Front.face[i][0] + Front.face[i][1] + " " +
					Right.face[i][0] + Right.face[i][1]);

		}
		System.out.println("");

		
		for(int i=0; i<2; i++){
			System.out.println("   " + Down.face[i][0] + Down.face[i][1]);
		}
		System.out.println("");

		
		for(int i=0; i<2; i++){
			System.out.println("   " + Back.face[i][0] + Back.face[i][1]);
		}
		System.out.println("--------");		
	}

	
	char[] tempArray = new char[2];
	char Temp;

	







	private void TurnFaceClockwise(FaceCreate f){ 
		Temp = f.face[0][1]; 
		f.face[0][1] = f.face[0][0]; 
		f.face[0][0] = f.face[1][0];
		f.face[1][0] = f.face[1][1];
		f.face[1][1] = Temp;
	}

	public void TurnLayerRightClockwise(){  

		TurnFaceClockwise(Right);
		tempArray[0] = Down.face[0][1]; 
		tempArray[1] = Down.face[1][1];

		Down.face[0][1] = Back.face[0][1];
		Down.face[1][1] = Back.face[1][1];
		Back.face[0][1] = Up.face[0][1];
		Back.face[1][1] = Up.face[1][1];
		Up.face[0][1] = Front.face[0][1];
		Up.face[1][1] = Front.face[1][1];
		Front.face[0][1] = tempArray[0];
		Front.face[1][1] = tempArray[1];
	}

	public void TurnLayerLeftClockwise(){ 
		TurnFaceClockwise(Left);
		tempArray[0] = Down.face[0][0]; 
		tempArray[1] = Down.face[1][0];

		Down.face[0][0] = Front.face[0][0];
		Down.face[1][0] = Front.face[1][0];
		Front.face[0][0] = Up.face[0][0];
		Front.face[1][0] = Up.face[1][0];
		Up.face[0][0] = Back.face[0][0];
		Up.face[1][0] = Back.face[1][0];
		Back.face[0][0] = tempArray[0];
		Back.face[1][0] = tempArray[1];
	}

	public void TurnLayerUpClockwise(){ 
		TurnFaceClockwise(Up);
		tempArray[0] = Front.face[0][0]; //store Front Row
		tempArray[1] = Front.face[0][1];

		Front.face[0][0] = Right.face[0][0];
		Front.face[0][1] = Right.face[0][1];
		Right.face[0][0] = Back.face[1][1];
		Right.face[0][1] = Back.face[1][0];
		Back.face[1][1] = Left.face[0][0]; 
		Back.face[1][0] = Left.face[0][1];
		Left.face[0][0] = tempArray[0];
		Left.face[0][1] = tempArray[1];

	}

	public void TurnLayerDownClockwise(){ 
		TurnFaceClockwise(Down);
		tempArray[0] = Front.face[1][0]; 
		tempArray[1] = Front.face[1][1];

		Front.face[1][0] = Left.face[1][0];
		Front.face[1][1] = Left.face[1][1];
		Left.face[1][0] = Back.face[0][1];
		Left.face[1][1] = Back.face[0][0];
		Back.face[0][1] = Right.face[1][0]; 
		Back.face[0][0] = Right.face[1][1]; 
		Right.face[1][0] = tempArray[0];
		Right.face[1][1] = tempArray[1];
	}

	public void TurnLayerFrontClockwise(){ 
		TurnFaceClockwise(Front);
		tempArray[0] = Up.face[1][0]; 
		tempArray[1] = Up.face[1][1];

		Up.face[1][0] = Left.face[1][1];
		Up.face[1][1] = Left.face[0][1];
		Left.face[0][1] = Down.face[0][0];
		Left.face[1][1] = Down.face[0][1];
		Down.face[0][0] = Right.face[1][0]; 
		Down.face[0][1] = Right.face[0][0]; 
		Right.face[0][0] = tempArray[0];
		Right.face[1][0] = tempArray[1];
	}

	public void TurnLayerBackClockwise(){ 
		TurnFaceClockwise(Back);
		tempArray[0] = Up.face[0][0];
		tempArray[1] = Up.face[0][1];

		Up.face[0][0] = Right.face[0][1];
		Up.face[0][1] = Right.face[1][1];
		Right.face[0][1] = Down.face[1][1];
		Right.face[1][1] = Down.face[1][0];
		Down.face[1][1] = Left.face[1][0]; 
		Down.face[1][0] = Left.face[0][0]; 
		Left.face[0][0] = tempArray[1];
		Left.face[1][0] = tempArray[0];
	}

	// scramble
	public void scramble(String strIn){ 
		
		int i = 0;
		while(i < strIn.length()){
			char char1 = strIn.charAt(i);
			if(i+1 < strIn.length()){
				char char2 = strIn.charAt(i+1);
				if(char2 == '\''){
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise(); 
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}	
					i+=2;
				}else if(char2 == '2'){
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise();  
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}
					i+=2;
				}else{
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}
					i+=1;
				}
			}else{
				switch(char1){
				case 'R': this.TurnLayerRightClockwise(); 
				break;
				case 'U': this.TurnLayerUpClockwise(); 
				break;
				case 'D': this.TurnLayerDownClockwise(); 
				break;
				case 'L': this.TurnLayerLeftClockwise(); 
				break;
				case 'B': this.TurnLayerBackClockwise(); 
				break;
				case 'F': this.TurnLayerFrontClockwise(); 
				break;
				default: break;
				}
				i+=1;
			}
		}
	

	}

	//SOLVE
	public int Solve(){
		
		numberOfTurns = 0 ; 

		this.print();
		int bottomPiecesSolved = 0;
		while (bottomPiecesSolved != 4){ 
			if(isDownTargetSolved()){ 
				System.out.println(numberOfTurns + ": Each Piece");
				this.TurnLayerDownClockwise();this.TurnLayerDownClockwise();this.TurnLayerDownClockwise(); 
				numberOfTurns++;
				
				bottomPiecesSolved++;
			} else { 
				

			
				if(targetStickerFacingUp() != null){ 
					while(Up.face[1][1] != 'W'){
						this.TurnLayerUpClockwise();
						numberOfTurns++;
			

					}
					
					this.scramble("RU2R'U'RUR'");
					numberOfTurns+=7;
				
				} else if (targetStickerFacingSideExists()){ 
					while(Front.getColor(0, 0) != 'W' && Front.getColor(0,1) != 'W'){ 
						this.TurnLayerUpClockwise();
						numberOfTurns++;
									
					}
					if(Front.face[0][1] == 'W'){ 
						
						this.scramble("URU'R'");
						numberOfTurns+=4;
						 
					} else { 
						this.scramble("U'RUR'");
						numberOfTurns+=4;
					
					}

				} else { 
					
					if(Front.face[1	][1] == 'W'){
						
						
						this.scramble("RU'R'URU'R'");
						numberOfTurns+=7;
					} else { 
						
						this.scramble("RUR'U'RUR'");
						numberOfTurns+=7;
					}
				}
			}
		}

		System.out.println(numberOfTurns + " :SIDE");

		






		if(this.numberOfStickersFacingUp('Y') != 4){
			
			if(this.numberOfStickersFacingUp('Y') == 1){
				if(Front.face[0][1] == 'Y'){
					



					while(Up.face[1][0] != 'Y'){
						numberOfTurns++;
						this.TurnLayerUpClockwise();
					}
					



					numberOfTurns+=7;
					this.scramble("RUR'URU2R'");
				} else {
					
					numberOfTurns++;
					this.TurnLayerUpClockwise();
				
					if(Front.face[0][1] == 'Y'){
						
					
						numberOfTurns+=7;
						this.scramble("RUR'URU2R'");
					} else {
					
						while(Up.face[0][1] != 'Y'){
							numberOfTurns++;
							this.TurnLayerUpClockwise();
						}
					
						numberOfTurns+=7;
						this.scramble("RU2R'U'RU'R'");
					} 
				}
			} else if(this.numberOfStickersFacingUp('Y') == 2){
			

				while(Up.face[1][1] != 'Y'){
					numberOfTurns++;
					this.TurnLayerUpClockwise();
				}
				if(Up.face[0][0] == 'Y'){
				
				
					if(Front.face[0][0] == 'Y'){
					
					
						numberOfTurns+=8;
						this.scramble("FR'F'RURU'R'");	
					} else {
						numberOfTurns+=9;
						this.scramble("U'F'RUR'U'R'FR");
					}
				} else if(Left.face[0][1] == 'Y'){ 
					numberOfTurns+=6;
					this.scramble("FRUR'U'F'");	
				} else if (Front.face[0][0] == 'Y'){ 
					numberOfTurns+=8;
					this.scramble("RUR'U'R'FRF'");
				} else if (Right.face[0][1] == 'Y'){
					numberOfTurns+=9;
					this.scramble("U'RUR'U'R'FRF'");
				} else { 
					numberOfTurns+=7;
					this.scramble("U'FRUR'U'F'");	
				}

			} else{
				while((Front.face[0][0] != 'Y' || Front.face[0][1] != 'Y')){ 
					numberOfTurns++;
					this.TurnLayerUpClockwise();
				}
				if(Right.face[0][1] == 'Y'){
					numberOfTurns+=8;
					this.scramble("R'FR2U'R2FR");	
				} else {
					numberOfTurns+=5;
					this.scramble("R2U2RU2R2");
				}
			}
		}

		
		System.out.println(numberOfTurns + ": OLL");

		




		if(areOpposites(Front.face[0][0], Front.face[0][1]) && (areOpposites(Right.face[0][0], Right.face[0][1])) 
				&& (areOpposites(Front.face[1][0], Front.face[1][1])) && (areOpposites(Right.face[1][0], Right.face[1][1]))){
	
			numberOfTurns+=3;
			this.scramble("R2 B2 R2");
			System.out.println("DIAG DIAG");
		} else if(this.isBarOnTop() && ((areOpposites(Front.face[1][0], Front.face[1][1])) && (areOpposites(Right.face[1][0], Right.face[1][1])))){
			System.out.println("OPP DIAG");
			
		
			while(Front.face[0][0] != Front.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			numberOfTurns+=7;
			this.scramble("R U' R F2 R' U R'");
		} else if((areOpposites(Front.face[0][0], Front.face[0][1]) && (areOpposites(Right.face[0][0], Right.face[0][1])))
				&& (this.isBarOnBottom())){
			System.out.println("DIAG OPP");
		
			
			while(Left.face[1][0] != Left.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}
			numberOfTurns+=9;
			this.scramble("R2 U R2 U' R2 U R2 U' R2");
		} else if(this.isBarOnTop()
				&& this.isBarOnBottom()){
			System.out.println("OPP OPP");
	
			while(Front.face[0][0] != Front.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			while(Front.face[1][0] != Front.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}
			numberOfTurns+=7;
			this.scramble("R2 U' B2 U2 R2 U' R2");
		} else if((areOpposites(Front.face[0][0], Front.face[0][1]) && areOpposites(Right.face[0][0], Right.face[0][1]))
				&& (Front.face[1][0] == Front.face[1][1] && Right.face[1][0] == Right.face[1][1])){
			System.out.println("DIAG SOLVE");
		
			numberOfTurns+=11;
			this.scramble("R U' R' U' F2 U' R U R' U F2");
		} else if ((Front.face[0][0] == Front.face[0][1] && Right.face[0][0] == Right.face[0][1]) && 
				(areOpposites(Front.face[1][0], Front.face[1][1]) && areOpposites(Right.face[1][0], Right.face[1][1]))){
			System.out.println("SOLVE DIAG");
		
			numberOfTurns+=12;
			this.scramble("R U' R' U' F2 U' R U R' D F2 R2");
		} else if (this.isBarOnTop()
				&& (Front.face[1][0] == Front.face[1][1] && Right.face[1][0] == Right.face[1][1])){
			System.out.println("OPP SOLVE");
		
			while(Left.face[0][0] != Left.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			numberOfTurns+=11;
			this.scramble("R U2 R' U' R U2 R' F R' F' R");
		} else if ((Front.face[0][0] == Front.face[0][1] && Right.face[0][0] == Right.face[0][1])  
				&& (this.isBarOnBottom())){
			System.out.println("SOLVE OPP");
		
			while(Left.face[1][0] != Left.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}		
			numberOfTurns+=11;
			this.scramble("R' U2 R' U' R U2 R' F R' F' R'");
		} else {
			System.out.println("PBL SKIP");
		} 
	


		System.out.println(numberOfTurns + ": PBL");

		
		while(Front.face[0][0] != Front.face[1][0]){
			numberOfTurns++;
			this.TurnLayerUpClockwise();
		}
		System.out.println(numberOfTurns + ": AUF");
		System.out.println(numberOfTurns);
		this.print();
		
		return numberOfTurns;
	}


	public boolean isDownTargetSolved(){  
		if(Down.getColor(0, 1) == 'W'){
			return true;
		}
		return false;
	}


	public int[] targetStickerFacingUp(){ 
		int[] point = new int[2];
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				
				if(Up.getColor(i, j) == 'W'){ 
				
					point[0] = i;
					point[1] = j;
					return point;
				}
			}
		}
		return null;
	}

	public boolean targetStickerFacingSideExists(){ 
		for(int j=0; j<2; j++){ 
			if(Left.getColor(0, j) == 'W'){
				return true;
			} else if(Front.getColor(0, j) == 'W'){
				return true;
			} else if(Right.getColor(0,j) == 'W'){
				return true;
			} else if(Back.getColor(1, j) == 'W'){
				return true;
			}
		}
		return false;
	}

	public int numberOfStickersFacingUp(char color){
		int sum = 0;
		for(int i=0; i < 2; i++){
			for(int j =0; j< 2; j++){
				if(Up.getColor(i, j) == color){
					sum++;
				}
			}
		}

		return sum;
	}

	public static boolean areOpposites(char a, char b){
		if((a == 'W' && b == 'Y') || (a == 'Y' && b =='W') || ( a == 'B' && b == 'G') || (a == 'G' && b == 'B') || (a == 'R' && b == 'O') || (a == 'O' && b == 'R')){
			return true;
		}
		return false;
	}

	public boolean isBarOnTop(){

		if(Front.face[0][0] == Front.face[0][1] && Right.face[0][0] != Right.face[0][1]){
			return true;
		} else if (Right.face[0][0] == Right.face[0][1] && Front.face[0][0] != Front.face[0][1]){
			return true;
		} else if (areOpposites(Front.face[0][0], Front.face[0][1]) && !areOpposites(Right.face[0][0], Right.face[0][1])){
			return true;
		} else if (areOpposites(Right.face[0][0], Right.face[0][1]) && !areOpposites(Front.face[0][0], Front.face[0][1])){
			return true;
		}
		return false;
	}

	public boolean isBarOnBottom(){
		if(Front.face[1][0] == Front.face[1][1] && Right.face[1][0] != Right.face[1][1]){
			return true;
		} else if (Right.face[1][0] == Right.face[1][1] && Front.face[1][0] != Front.face[1][1]){
			return true;
		} else if (areOpposites(Front.face[1][0], Front.face[1][1]) && !areOpposites(Right.face[1][0], Right.face[1][1])){
			return true;
		} else if (areOpposites(Right.face[1][0], Right.face[1][1]) && !areOpposites(Front.face[1][0], Front.face[1][1])){
			return true;
		}
		return false;
	}

	public static String generateScramble(){
		String scramble = "";
		String[] moves = {"R", "U", "F", "R'", "U'", "F'", "R2", "U2", "F2"};
		for(int i=0; i < 9; i++){
			Random notActuallyARandomNumber =  new Random();
			int index = notActuallyARandomNumber.nextInt(9); 
			scramble += moves[index];
			scramble += " ";
		}
		return scramble;
		 
	}

}