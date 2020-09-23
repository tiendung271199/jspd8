package model.bean;

public class News {
	private int id;
	private String name;
	private String preview;
	private String detail;
	private String picture;
	private int idDanhMuc;

	public News() {

	}
	
	public News(int id, String name, String preview) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
	}

	public News(int id, String name, String preview, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
	}
	
	public News(int id, String name, String preview, String detail, String picture, int idDanhMuc) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.picture = picture;
		this.idDanhMuc = idDanhMuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getIdDanhMuc() {
		return idDanhMuc;
	}

	public void setIdDanhMuc(int idDanhMuc) {
		this.idDanhMuc = idDanhMuc;
	}
	
}
