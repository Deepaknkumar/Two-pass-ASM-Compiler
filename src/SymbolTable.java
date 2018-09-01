/**
 * 
 */

/**
 * @author deepakkumar
 *
 */
public class SymbolTable implements SymbolCollection {
	
	private Symbol head;
	/**
	 * 
	 */
	public SymbolTable() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}

	/* (non-Javadoc)
	 * @see SymbolCollection#add(java.lang.String, int)
	 */
	@Override
	public void add(String label, int location) {
		// TODO Auto-generated method stub
		Symbol tmp1 = new Symbol();
		tmp1.setLabel(label);
		tmp1.setLocation(location);
//		System.out.println(label + " " + location + " " + tmp1);
		
		if(head==null) {
			head = tmp1;
		}else {
			Symbol tmp = head;
			while(tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
//			System.out.println(label + " added.");
			tmp.setNext(tmp1);
//			tmp = tmp.getNext();
			
		}
	}

	/* (non-Javadoc)
	 * @see SymbolCollection#add(java.lang.String, int, int)
	 */
	@Override
	public void add(String label, int location, int value) {
		// TODO Auto-generated method stub
		add(label,location);
			Symbol tmp = head;
			while(tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setValue(value);
	}

	/* (non-Javadoc)
	 * @see SymbolCollection#getLabelLocation(java.lang.String)
	 */
	@Override
	public int getLabelLocation(String label) {
		// TODO Auto-generated method stub
		int location = -1;
		Symbol tmp = head;
//		System.out.println(head.getNext());

			while(tmp!= null) {
//				System.out.println(tmp.getLabel() + " " + label);
				if(tmp.getLabel().equals(label)) {
					location = tmp.getLocation();
					break;
				}
				tmp = tmp.getNext();
//				System.out.println("+1");
			}
			return location;
//		}
	}

	/* (non-Javadoc)
	 * @see SymbolCollection#getLabelValueByLocation(int)
	 */
	@Override
	public int getLabelValueByLocation(int location) {
		// TODO Auto-generated method stub
		int value = -1;
		Symbol tmp = head;
//		System.out.println(head.getNext());

			while(tmp!= null) {
				if(tmp.getLocation() == location) {
					value = tmp.getValue();
					break;
				}
				tmp = tmp.getNext();
//				System.out.println("+1");
			}
			return value;
	}
	

	/* (non-Javadoc)
	 * @see SymbolCollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int length = 0;
		Symbol tmp = head;
		while(tmp!=null) {
			length++;
			tmp = tmp.getNext();
		}
		return length;
	}
	
	public String toString() {
		String str = "";
		Symbol tmp = head;
		while(tmp!=null) {
			str = str + " " + tmp.getLabel() + " " + tmp.getLocation() + " " + tmp.getValue() + "\n";
			tmp = tmp.getNext();
		}
		return str;
	}
}
