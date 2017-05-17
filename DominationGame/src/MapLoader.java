import java.util.List;

public class MapLoader {
	private static CSVRead csvReader;
	public MapLoader(String fileName,Cell[][] cellArr){
		csvReader = new CSVRead(fileName);
		List<String []> list = csvReader.readCsv();
		for(int i=0;i<StageFrame.CELL_COUNT;i++){
			for(int j=0;j<StageFrame.CELL_COUNT;j++){
				//System.out.print(list.get(i)[j]);
				if(list.get(i)[j].equals("1")) {
					cellArr[i][j].setState(Cell.TREASURE);
				}
			}
			//System.out.println();
		}
	}
}
