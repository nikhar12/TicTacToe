import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Game {

	private final static int[][] board = new int[3][3];
	private int row,col;
	
	public static void userTurn(int row,int col)
	{
		board[row][col] = 0;
	}
	
	public static void initBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j] =-1;
			}
		}
	}
	
	public static Map<Integer,Integer> compTurn()
	{
		Map<Integer,Integer> criticalPositionMap = new HashMap<Integer,Integer>();
		Map<Integer,Integer> possiblePositionMap = new HashMap<Integer,Integer>();
		Map<Integer,Integer> compTurnPositionMap= new HashMap<Integer,Integer>();
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]==0)
				{
				 //check rows
					int userRowCheckCount=0;
					int compRowCheckCount=0;
					Map<Integer,Integer> emptyMap = new HashMap<Integer,Integer>();
					//if(i!=2)
					{
					for(int r=i;r<3;r++)
					{
						if(board[r][j]==0)
						{
							userRowCheckCount++;
						}
						if(board[r][j]==-1)
						{
							emptyMap.put(r, j);
						}
						if(board[r][j]==1)
						{
							compRowCheckCount++;
						}
					}
					if((userRowCheckCount!=3)|| (compRowCheckCount!=3))
					{
						//if not already won by user or computer
						if(userRowCheckCount==2 || compRowCheckCount==2)
						{
							
							criticalPositionMap.putAll(emptyMap);
						}
						else
						{
							possiblePositionMap.putAll(emptyMap);
						}
						
					}
					}
					
					//check columns
					
					int userColCheckCount=0;
					int compColCheckCount=0;
					emptyMap = new HashMap<Integer,Integer>();
					//if(i!=2)
					{
					for(int r=j;r<3;r++)
					{
						if(board[i][r]==0)
						{
							userColCheckCount++;
						}
						if(board[i][r]==-1)
						{
							emptyMap.put(i, r);
						}
						if(board[i][r]==1)
						{
							compColCheckCount++;
						}
					}
					if((userColCheckCount!=3)|| (compColCheckCount!=3))
					{
						//if not already won by user or computer
						if(userColCheckCount==2 || compColCheckCount==2)
						{
							
							criticalPositionMap.putAll(emptyMap);
						}
						else
						{
							possiblePositionMap.putAll(emptyMap);
						}
						
					}
					}
					
					//check diagonals
					
					
					
				}
			}
		}
		//check diagonal 1 - top left to bottom right
		int userDiagonalCheckCount=0;
		int compDiagonalCheckCount=0;
		Map<Integer,Integer> emptyMap = new HashMap<Integer,Integer>();
		for(int i=0;i<3;i++)
		{
			
			if(board[i][i]==0)
			{
				userDiagonalCheckCount++;
			}
			if(board[i][i]==-1)
			{
				emptyMap.put(i, i);
			}
			if(board[i][i]==1)
			{
				compDiagonalCheckCount++;
			}
			
		}
		
		if(userDiagonalCheckCount!=3 || compDiagonalCheckCount!=3)
		{
			//if not already won by user or computer
			if(userDiagonalCheckCount==2 || compDiagonalCheckCount==2)
			{
				
				criticalPositionMap.putAll(emptyMap);
			}
			else
			{
				possiblePositionMap.putAll(emptyMap);
			}
	
		}
		

		//check diagonal 2 - bottom left to top right
				userDiagonalCheckCount=0;
				compDiagonalCheckCount=0;
				emptyMap = new HashMap<Integer,Integer>();
				for(int i=0,j=2;i<3;i++,j--)
				{
					
					if(board[j][i]==0)
					{
						userDiagonalCheckCount++;
					}
					if(board[j][i]==-1)
					{
						emptyMap.put(j, i);
					}
					if(board[j][i]==1)
					{
						compDiagonalCheckCount++;
					}
					
				}
				
				if(userDiagonalCheckCount!=3 || compDiagonalCheckCount!=3)
				{
					//if not already won by user or computer
					if(userDiagonalCheckCount==2 || compDiagonalCheckCount==2)
					{
						
						criticalPositionMap.putAll(emptyMap);
					}
					else
					{
						possiblePositionMap.putAll(emptyMap);
					}
			
				}
			
		
		if(criticalPositionMap.size()>0)
		{
			Map.Entry<Integer, Integer> entry = criticalPositionMap.entrySet().iterator().next();
			compTurnPositionMap.put(entry.getKey(), entry.getValue());
			board[entry.getKey()][entry.getValue()] = 1;
		}
		else
		{
			Map.Entry<Integer, Integer> entry = possiblePositionMap.entrySet().iterator().next();
			compTurnPositionMap.put(entry.getKey(), entry.getValue());
			board[entry.getKey()][entry.getValue()] = 1;
		}
		return compTurnPositionMap;
	}
	
	
	public static void printBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]);
				if(j!=2)
				{
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generating fuck all method stub
		initBoard();
		while(true)
		{
		printBoard();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			String[] arr = line.split(" ");
			int row = Integer.parseInt(arr[0]);
			int col = Integer.parseInt(arr[1]);
			userTurn(row,col);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compTurn();
		
		
		}

	}

}
