package com.entity;

public class Cheliangxinxi {
    private Integer id;
	private String cheliangbianhao;	private String cheliangmingcheng;	private String leixing;	private String chepaihao;	private String tupian;	private String rizujia;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getCheliangbianhao() {
        return cheliangbianhao;
    }
    public void setCheliangbianhao(String cheliangbianhao) {
        this.cheliangbianhao = cheliangbianhao == null ? null : cheliangbianhao.trim();
    }	public String getCheliangmingcheng() {
        return cheliangmingcheng;
    }
    public void setCheliangmingcheng(String cheliangmingcheng) {
        this.cheliangmingcheng = cheliangmingcheng == null ? null : cheliangmingcheng.trim();
    }	public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }	public String getChepaihao() {
        return chepaihao;
    }
    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? null : chepaihao.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	public String getRizujia() {
        return rizujia;
    }
    public void setRizujia(String rizujia) {
        this.rizujia = rizujia == null ? null : rizujia.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
