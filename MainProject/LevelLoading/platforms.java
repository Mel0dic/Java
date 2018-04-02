import java.util.List;
import java.util.ArrayList;

public class platforms{

	private List<List<Integer>> platformCoords = new ArrayList<List<Integer>>();
	private int rightWall;
	private int leftWall;

	public platforms(List<List<Character>> theMap, int blockSize){
		int widthOfMap = theMap.get(0).size();
		int heightOfMap = theMap.size();
		int blocksFound = 0;
		int start;
		int end;
		for(int i = 0; i < heightOfMap; i++){
			for(int p = 0; p < widthOfMap; p++){
				if(theMap.get(i).get(p) == 'X' || theMap.get(i).get(p) == '~'){
					start = p * blockSize;
					end = start;
					if(theMap.get(i).get(p) == 'X'){
						while(theMap.get(i).get(p) == 'X'){
							end += blockSize;
							p++;
						}
					}else{end += blockSize;}
					platformCoords.add(new ArrayList<Integer>());
					platformCoords.get(blocksFound).add(start);
					platformCoords.get(blocksFound).add(end);
					platformCoords.get(blocksFound).add(i * blockSize);
					blocksFound++;
				}
			}
		}
		int i = 0;
		while(theMap.get(0).get(i) == '*'){
			i++;
		}
		leftWall = i;
		while(theMap.get(0).get(i) != '*'){
			i++;
		}
		rightWall = i-1;
	}

	public List<List<Integer>> getPlatforms(){
		return platformCoords;
	}

	public int getLeftWall(){
		return leftWall;
	}

	public int getRightWall(){
		return rightWall;
	}

}