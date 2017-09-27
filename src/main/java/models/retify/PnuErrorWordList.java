package models.retify;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PnuErrorWordList
{

    @SerializedName("repeat")
    @Expose
    private String repeat;
    @SerializedName("pnuErrorWord")
    @Expose
    private PnuErrorWord[] pnuErrorWord;
    @SerializedName("error")
    @Expose
    private Error error;

    public String getRepeat ()
    {
        return repeat;
    }

    public void setRepeat (String repeat)
    {
        this.repeat = repeat;
    }

    public PnuErrorWord[] getPnuErrorWord ()
    {
        return pnuErrorWord;
    }

    public void setPnuErrorWord (PnuErrorWord[] PnuErrorWord)
    {
        this.pnuErrorWord = PnuErrorWord;
    }

    public Error getError ()
    {
        return error;
    }

    public void setError (Error error)
    {
        this.error = error;
    }

}
