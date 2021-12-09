import java.util.ArrayList;

public class zhou_lab13 {
	
	public static void main(String[] args)
	{
		
		zhou_lab13 l = new zhou_lab13();
		String filename = args[0];
		l.readData(filename);
		System.out.println(l.getTotalCount());
		System.out.println(l.getOddCount());
		System.out.println(l.getEvenCount());
		System.out.println(l.getDistinctGreaterThanFiveCount());
		for(Integer e:l.getResult1()) {
			System.out.println(e);
		}
		for(Integer e:l.getResult2()) {
			System.out.println(e);
		}
		for(Integer e:l.getResult3()) {
			System.out.println(e);
		}
		
	}
	
	private ArrayList<Integer> list = new ArrayList<>();
	
	public void readData(String filename){

        try
		{  	
        	java.io.BufferedReader sortReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));            
            String inn;

            while( (inn = sortReader.readLine() )!= null ){
                list.add(Integer.parseInt(inn));   
            }
                       
        }catch(Exception e){
        	
			System.out.println(e.toString());
			System.exit(0);
		}
    }
	public long getTotalCount(){
		
		return list.stream().count();
	
	}
	public long getOddCount(){
		
		return list.stream().filter(x -> x % 2 != 0).count();
		
	}
	
	public long getEvenCount(){
		return list.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount(){
		return list.stream().filter(x -> (x>5)).distinct().count();

	}
	public Integer[] getResult1(){
		Integer[] list1 = list.stream().filter(x -> x % 2 == 0).filter(x -> (x>5)&& (x<50)). sorted().toArray(Integer[]::new);
		return list1;

	}
	public Integer[] getResult2() {
		Integer[] list2 = list.stream().limit(50).map(x -> x*x*3). toArray(Integer[]::new);
		return list2;
	}
	public Integer[] getResult3() {
		Integer[] list3=list.stream().filter(x -> x % 2 != 0).map(x->x*2). sorted().skip(20).distinct().toArray(Integer[]::new);
		return list3;
	}

}
