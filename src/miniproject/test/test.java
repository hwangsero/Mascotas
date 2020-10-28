package miniproject.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import miniproject.vo.AnimalVO;

public class test {
	public static void main(String[] args) throws Exception {
		List a = new ArrayList<>();
		List b = new ArrayList<>();
		b.add(1);
		b.add(2);
		List c = new ArrayList<>();
		c.add(3);
		c.add(4);
		List d = new ArrayList<>();
		d.add(5);
		d.add(6);
		List e = new ArrayList<>();
		e.add(7);
		e.add(8);
		List f = new ArrayList<>();
		f.add(9);
		f.add(10);
		a.add(b);
		a.add(c);
		a.add(d);
		a.add(e);
		a.add(f);
		
		System.out.println(a);
	}
}
