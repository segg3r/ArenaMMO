package by.segg3r.slicktest.logic.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tileset 
{
	private String path;

	public Tileset(String path) {
		super();
		this.path = path;
	}



	public TilesetDescriptor getTilesetDescriptor() 
	{
		try {
			TilesetDescriptor tilesetDescriptor;
			
			File file = new File(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			List<TilesetDescriptor> result = new ArrayList<TilesetDescriptor>();
			String line;
			String[] parametres = br.readLine().split(";");
			tilesetDescriptor = new TilesetDescriptor(parametres[0], Integer.parseInt(parametres[1]), Integer.parseInt(parametres[2]));
			result.add(tilesetDescriptor);
			
			while ((line = br.readLine()) != null) 
			{
				parametres = line.split(";");
				tilesetDescriptor.getDescriptors().add(new TileDescriptor(parametres[0], Integer.parseInt(parametres[1]), Integer.parseInt(parametres[2]), 
						Integer.parseInt(parametres[3]), Integer.parseInt(parametres[4]), Integer.parseInt(parametres[5]), Integer.parseInt(parametres[6])));
			}
			br.close();

			return tilesetDescriptor;
		} catch (Exception e) {
			return null;
		}
	}
}
