
public class Card {

	private String name;
	private String idlist;
	private String id;
	private String desc;
	
	public Card() {
	}
	
	public Card(String id, String desc, String idlist, String name) {
		super();
		this.name = name;
		this.idlist = idlist;
		this.id = id;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdlist() {
		return idlist;
	}

	public void setIdlist(String idlist) {
		this.idlist = idlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
