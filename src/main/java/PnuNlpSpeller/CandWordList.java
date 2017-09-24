package PnuNlpSpeller;



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CandWordList
{

    @SerializedName("m_nCount")
    @Expose
    private int m_nCount;
    @SerializedName("candWord")
    @Expose
    private String[] candWord;

    public int getM_nCount ()
    {
        return m_nCount;
    }

    public void setM_nCount (int m_nCount)
    {
        this.m_nCount = m_nCount;
    }

    public String[] getCandWord ()
    {
        return candWord;
    }

    public void setCandWord (String[] CandWord)
    {
        this.candWord = CandWord;
    }

}
