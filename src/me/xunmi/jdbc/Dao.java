package me.xunmi.jdbc;

import java.util.List;

import com.dogtperfect.buffer.Hero;

public interface Dao {
	public void add(Hero h);
	public void update(Hero h);
	public void delete(int id);
	public Hero get(int id);
	public List<Hero> list();
	public List<Hero> list(int start, int count);
}
