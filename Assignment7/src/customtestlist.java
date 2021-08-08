
public class customtestlist {

	public static void main(String[] args) {
		CustomList<Integer> myCustomList = new CustomArrayList<>();
		myCustomList.add(1);
		myCustomList.remove(0);
		myCustomList.add(4);
		myCustomList.add(2);
		myCustomList.add(3);
		myCustomList.add(5);
		myCustomList.add(0, 1);
		myCustomList.add(7, 6);
		for(int i = 0; i < myCustomList.getSize(); i++) {
			System.out.println(myCustomList.get(i));
		}
	}

}
