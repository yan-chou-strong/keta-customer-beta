/**
 * There are <a href="https://github.com/ketayao/keta-custom">keta-custom</a> code generation
 */
package com.sample.entity;

import com.ketayao.ketacustom.entity.Idable;
import com.ketayao.ketacustom.entity.main.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sample_task")
public class Task implements Idable<Long>{
	@Id
	/**
	 * JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
	 TABLE：使用一个特定的数据库表格来保存主键。
	 SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
	 IDENTITY：主键由数据库自动生成（主要是自动增长型）
	 AUTO：主键由程序控制。
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	/**
	 * 标题
	 */
    @Column(nullable=false, length=64)
    private String title;
    
	/**
	 * 内容
	 */
    @Column(length=256)
    private String content;
    
	/**
	 * 等级
	 */
    @Column(nullable=false, length=64)
    private String level;
    
	/**
	 * 创建人
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
    
	/**
	 * 创建时间
	 *  (1) 如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'要在查询时获得年月日，在该属性上标注@Temporal(TemporalType.DATE) 会得到形如'yyyy-MM-dd' 格式的日期。

	 (2)如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'要获得时分秒，在该属性上标注 @Temporal(TemporalType.TIME) 会得到形如'HH:MM:SS' 格式的日期。

	 (3)如果在某类中有Date类型的属性，数据库中存储可能是'yyyy-MM-dd hh:MM:ss'要获得'是'yyyy-MM-dd hh:MM:ss'，在该属性上标注 @Temporal(TemporalType.TIMESTAMP) 会得到形如'HH:MM:SS' 格式的日期
	 */
    @Column(length=19)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param title the title to set
	 */
    public void setTitle(String title){
       this.title = title;
    }
    
    /**
     * @return the title 
     */
    public String getTitle(){
       return this.title;
    }
	
	/**
	 * @param content the content to set
	 */
    public void setContent(String content){
       this.content = content;
    }
    
    /**
     * @return the content 
     */
    public String getContent(){
       return this.content;
    }
	
	/**
	 * @param level the level to set
	 */
    public void setLevel(String level){
       this.level = level;
    }
    
    /**
     * @return the level 
     */
    public String getLevel(){
       return this.level;
    }
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param createTime the createTime to set
	 */
    public void setCreateTime(Date createTime){
       this.createTime = createTime;
    }
    
    /**
     * @return the createTime 
     */
    public Date getCreateTime(){
       return this.createTime;
    }
}
