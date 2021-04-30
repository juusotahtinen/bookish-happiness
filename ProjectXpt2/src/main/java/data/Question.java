package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int kysymys_id;
	private String kysymys;

//	//bi-directional many-to-one association to Fish
//	@OneToMany(mappedBy="question", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JsonManagedReference //To handle converting object to JSON and backwards
//	private List<Question> questionlist;
	
	public Question() {
		
	}
	public Question(String kysymys) {
		this.kysymys=kysymys;
	}
	
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

//	public List<Question> getQuestionlist() {
//		if (this.questionlist==null) {
//			questionlist=new ArrayList<>();
//		}
//		return this.questionlist;
//	}
//
//	public void setQuestionlist(List<Question> questionlist) {
//		this.questionlist = questionlist;
//	}
//
//	public Fish addFish(Fish fish) {
//		getFishlist().add(fish);
//		fish.setKid(this);
//
//		return fish;
//	}
//
//	public Fish removeFish(Fish fish) {
//		getFishlist().remove(fish);
//		fish.setKid(null);
//		return fish;
//	}
	
	
	public String toString() {
		return kysymys_id+":  "+kysymys;
	}
}


