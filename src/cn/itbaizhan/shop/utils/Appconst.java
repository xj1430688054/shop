package cn.itbaizhan.shop.utils;

public class Appconst {
	private static String pid;
	private static String oid;
	private static Integer ppid;
	
	public static Integer getPpid() {
		return ppid;
	}
	public static void setPpid(Integer ppid) {
		Appconst.ppid = ppid;
	}
	public static String getPid() {
		return pid;
	}
	public static void setPid(String pid) {
		Appconst.pid = pid;
	}
	public static String getOid() {
		return oid;
	}
	public static void setOid(String oid) {
		Appconst.oid = oid;
	}
	

}
