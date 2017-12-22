package ie.gmit.sw.utils;

public class Query {
	private String job_num;
	private String str;
	public String getJob_num() {
		return job_num;
	}
	public void setJob_num(String job_num) {
		this.job_num = job_num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return "Query [job_num=" + job_num + ", str=" + str + "]";
	}
	
}
