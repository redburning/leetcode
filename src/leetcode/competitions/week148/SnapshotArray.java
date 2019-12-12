package leetcode.competitions.week148;


public class SnapshotArray {
	
	private int length;
	private int arr[];
	//private int copy[];
	private int setIndexRecords[];
	private int setValueRecords[];
	private int currentIndex;
	//private int lastIndex;
	private int counter;
	private int[][] snapshots;
	
	public SnapshotArray(int length) {
		this.length = length;
		snapshots = new int[50000][];
		arr = new int[length];
		//copy = new int[length];
		setIndexRecords = new int[50000];
		setValueRecords = new int[50000];
		currentIndex = 0;
		//lastIndex = 0;
        counter = 0;
    }
    
    public void set(int index, int val) {
        arr[index] = val;
        setIndexRecords[currentIndex] = index;
        setValueRecords[currentIndex] = val;
        currentIndex++;
    }
    
    private int[] backup() {
    	int[] backup = new int[length];
    	for (int i = 0; i < currentIndex; i++) {
    		backup[setIndexRecords[i]] = setValueRecords[i];
    	}
    	return backup;
    }
    
    public int snap() {
        int[]copy = backup();
        int snap_id = counter;
        counter++;
        snapshots[snap_id] = copy;
        return snap_id;
    }
    
    public int get(int index, int snap_id) {
        return snapshots[snap_id][index];
    }
}
