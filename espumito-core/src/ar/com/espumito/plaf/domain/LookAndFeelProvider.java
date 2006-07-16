package ar.com.espumito.plaf.domain;


/**
 * LookAndFeels (LAFs for short) provider interface.
 * 
 * @author guybrush Date: 01-mar-2006
 * 
 */
public interface LookAndFeelProvider {
	/**
	 * @return Finds all LAFs.
	 */
	public LookAndFeel[] findAll();

	/**
	 * Find a LAF.
	 * 
	 * @param id
	 *            LAF's id.
	 * @return The LAF, or null if not found.
	 */
	public LookAndFeel findByPrimaryKey(String id);
}
