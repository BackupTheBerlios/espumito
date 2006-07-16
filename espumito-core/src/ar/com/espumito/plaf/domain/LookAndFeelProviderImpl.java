package ar.com.espumito.plaf.domain;

import java.util.Collection;

import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.plaf.persistence.LookAndFeelDAO;


public class LookAndFeelProviderImpl
    implements LookAndFeelProvider
{
    private LookAndFeelDAO lookAndFeelDao;
    
    public LookAndFeelProviderImpl(LookAndFeelDAO lookAndFeelDao)
    {
        super();
        this.lookAndFeelDao = lookAndFeelDao;
    }

    public LookAndFeel[] findAll()
    {
        Collection all = null;
        try
        {
            all = this.lookAndFeelDao.findAll();
        } catch (PersistenceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        LookAndFeel[] ret = new LookAndFeel[all.size()];
        return (LookAndFeel[]) all.toArray(ret);
    }

    public LookAndFeel findByPrimaryKey(String id)
    {
        try
        {
            return (LookAndFeel) this.lookAndFeelDao.find(id);
        } catch (PersistenceException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
