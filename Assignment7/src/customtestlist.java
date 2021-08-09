
public class customtestlist {

	public static void main(String[] args) {
		CustomList<String> myCustomList = new CustomArrayList<>();
		
//		myCustomList.add(1);
//		myCustomList.add(2);
//		myCustomList.add(3);
//		myCustomList.add(4);
//		myCustomList.add(5);
//		myCustomList.add(6);
//		myCustomList.add(7);
//		myCustomList.add(8);
//		myCustomList.add(9);
//		myCustomList.add(10);
		
		for(int i = 0; i < 25; i++) {
			myCustomList.add("element "+ (i+1));
		}
		myCustomList.add("element 26");
		myCustomList.add(25, "element 26.1");
		myCustomList.add(0, "element 0");
		myCustomList.add(10, "element 10.1");
		myCustomList.remove(11);
		//myCustomList.remove(28);

		
		for(int i = 0; i < myCustomList.getSize(); i++) {
			System.out.println(myCustomList.get(i));
		}
		
		
	}

}
