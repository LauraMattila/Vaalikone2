package client;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.Ehdokkaat;

public class CandidatesClient {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String uri = "http://localhost:8080/rest/candidatesservice/update";
//
//		//A list of DogBreed objects to send to our web-service 
//		ArrayList<DogBreed> list=getBreeds();
//		Client asiakas=ClientBuilder.newClient();
//		WebTarget wt=asiakas.target(uri);
//		Builder b=wt.request();
//		
//		//Create an Entity object to send by post method
//		Entity<ArrayList<DogBreed>> e=Entity.entity(list,MediaType.APPLICATION_JSON);
//
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<DogBreed>> genericList = new GenericType<List<DogBreed>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<DogBreed> returnedList=b.post(e, genericList);
//		
//		//And print the objects
//		for (DogBreed db:returnedList) {
//			System.out.println(db);
//		}
//	}
//	//This method just creates a list
//	private static ArrayList<DogBreed> getBreeds() {
//		// TODO Auto-generated method stub
//		ArrayList<DogBreed> list=new ArrayList<>();
//		DogBreed db=new DogBreed(1, "Siberian Laika", 30);
//		list.add(db);
//		db=new DogBreed(2, "Husky", 40);
//		list.add(db);
//		db=new DogBreed(3, "All Breed", 15);
//		list.add(db);
//		db=new DogBreed(4, "Hound Dog", 20);
//		list.add(db);
//		db=new DogBreed(5, "Chihuahua", 1);
//		list.add(db);
//		return list;
//	}
}

