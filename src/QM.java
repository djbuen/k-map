
import com.sun.xml.internal.fastinfoset.util.CharArray;
import java.util.ArrayList;
import java.util.LinkedList;
import org.omg.CORBA.INTERNAL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dave
 */
public class QM extends qmOperations{
    public int product[];
    public int nvar;
    public QM next;
    public int used;

    public QM(){
    int dproduct[] = {-1,-1,-1,-1};
    this.product = dproduct;
    nvar = 4;
    next = null;
    used = 0;
    }
}
