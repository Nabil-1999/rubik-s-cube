public class FaceCreate {

    char[][] face; // dimenssion 2*2
	
	public FaceCreate(){ 
		face = new char[2][2];
	}
	
	public FaceCreate(char s){ //ndiro face m3a les coleurs dyal kol face 
		face = new char[2][2];
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				face[i][j] = s;
			}
		}	
	}
	
	public char getColor(int x, int y){
		return face[x][y];
	}
}