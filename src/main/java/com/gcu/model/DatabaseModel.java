package com.gcu.model;

import java.util.ArrayList;

public class DatabaseModel
{
	private static ArrayList<UserModel> userList = new ArrayList<UserModel>();

	
	public ArrayList<UserModel> getUserList() {
		return userList;
	}
	public static void setUserList(ArrayList<UserModel> newList) {
		userList = newList;
	}
	public static void addUser(UserModel newUser)
	{
		userList.add(newUser);
	}
	public static int getSize()
	{
		return userList.size();
	}
	public static boolean findLogin(LoginModel loginDetails)
	{
		System.out.println("-> Size of user list: " + userList.size());
		
		if (userList.size() == 0)
		{
			return false;
		}
		for (int tl = 0; tl <= userList.size() - 1; tl++)
		{
			System.out.println("Loop on User " + tl);
			System.out.println("--> " + userList.get(tl).toString());
			System.out.println("--> " + loginDetails.toString());

			System.out.println();
			
			if (loginDetails.getUsername().equals(userList.get(tl).getUsername()) &&
					loginDetails.getPassword().equals(userList.get(tl).getPassword()))
			{
				return true;
			}
		}
		return false;
	}
}