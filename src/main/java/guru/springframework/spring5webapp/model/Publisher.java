package guru.springframework.spring5webapp.model;

import java.util.Objects;

//import javax.persistence.Entity;
//import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.HashSet;
//import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String addressLine1;
	private String city;
	private String state;
	private String zip;

	@OneToMany
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {		
	}

	public Publisher(String name, String addressLine1, String city, String state, String zip) {
		this.name = name;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Publisher [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zip=");
		builder.append(zip);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Publisher publisher = (Publisher)obj;
		
		return id != null ? id.equals(publisher.id) : publisher.id == null;
	}

}
