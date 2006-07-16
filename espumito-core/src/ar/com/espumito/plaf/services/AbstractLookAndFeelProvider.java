package ar.com.espumito.plaf.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.domain.LookAndFeelProvider;

public abstract class AbstractLookAndFeelProvider implements LookAndFeelProvider {
	private Map lookAndFeels = new HashMap();
	private boolean initiated = false;
	
	/**
	 * 
	 */
	public AbstractLookAndFeelProvider() {
		super();
	}

	/**
	 * @see ar.com.espumito.plaf.domain.LookAndFeelProvider#findAll()
	 */
	public LookAndFeel[] findAll() {
		init();
		Object[] values = this.lookAndFeels.values().toArray();
		LookAndFeel[] lafs = new LookAndFeel[values.length];
		System.arraycopy(values, 0, lafs, 0, values.length);
		return lafs;
	}

	/**
	 * @see ar.com.espumito.plaf.domain.LookAndFeelProvider#findByPrimaryKey(java.lang.String)
	 */
	public LookAndFeel findByPrimaryKey(String id) {
		init();
		LookAndFeel laf = (LookAndFeel) this.lookAndFeels.get(id);
		return laf;
	}
	
	/**
	 * 
	 */
	public final void init()
	{
		if (!this.initiated)
		{
			loadLookAndFeels();
			setInitiated(true);
		}
	}
	
	/**
	 * 
	 */
	protected abstract void loadLookAndFeels();

	/**
	 * @return Returns the initiated.
	 */
	public boolean isInitiated() {
		return this.initiated;
	}

	/**
	 * @param initiated The initiated to set.
	 */
	protected final void setInitiated(boolean initiated) {
		this.initiated = initiated;
	}
	
	protected void addLookAndFeel(LookAndFeel lookAndFeel)
	{
		this.lookAndFeels.put(lookAndFeel.getId(), lookAndFeel);
	}
	
	/**
	 * @param lookAndFeels
	 */
	protected void addLookAndFeels(Collection lookAndFeels)
	{
		for (Iterator iter = lookAndFeels.iterator(); iter.hasNext();) {
			LookAndFeel laf = (LookAndFeel) iter.next();
			addLookAndFeel(laf);
		}
	}

}
