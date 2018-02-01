/**
 * Created by naliv on 31.01.2018.
 */
public class Percolation {
    private Site[] sites;
    private int n;

    private void checkIsCorrect (int row, int col) {
        if (row > n  || row < 0 || col > n || col < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Percolation (int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        sites = new Site[n*n];

        int tempCount = 0;
        for (int i = 0; i < n*n; i++, tempCount++) {
            sites[i] = new Site();
            sites[i].setValue(tempCount);
        }
    }

    public void union (int firstIndex, int secondIndex) {
        int i = root(firstIndex);
        int j = root(secondIndex);
        sites[i].setValue(j);
    }

    public int root (int value) {
        while (value != sites[value].getValue()) {
            value = sites[value].getValue();
        }
        return value;
    }
    public void open (int row, int col) {
        checkIsCorrect(row, col);
        int tempValue = row*n+col;
        sites[tempValue].setSiteState(Site.State.open);
        if (row != 0) {
            if (isOpen(row - 1, col)) {
                union(tempValue, (row - 1) * n + col);
            }
        }

        if (col != 4) {
            if (isOpen(row, col + 1)) {
                union(row * n + col + 1, tempValue);
            }
        }

        if (row !=4 ) {
            if (isOpen(row + 1, col)) {
                union((row + 1) * n + col, tempValue);
            }
        }

        if (col!=0) {
            if (isOpen(row, col - 1)) {
                union(tempValue, row * n + col - 1);
            }
        }

        if (percolates()) {
            System.out.println("BINGO");
        }
    }

    public boolean isOpen (int row, int col){
        checkIsCorrect(row, col);
        int tempValue = row*n+col;
        return sites[tempValue].getSiteState() == Site.State.open;
    }

    /*public boolean isFull (int row, int col){
        checkIsCorrect(row, col);
    }*/

    public int numberOfOpenSites(){
        int numberOfOpen = 0;
        for(int i = 0; i < sites.length; i++ ){
            //TODO: add count number of open sites
        }
        return numberOfOpen;
    }

    public boolean percolates(){
        int temp = n*n;
        for(int i = temp-1; i > temp - n - 1 ; i--){
            int rootValue = root(i);
            if(rootValue >= 0 && rootValue < n ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(5);
    }
}
