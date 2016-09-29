package model;

import java.io.Serializable;

/**
 * Created by Mohammad on 9/29/2016.
 */
public class Satellite implements Serializable {
    private static final long serialVersionUID = 2388023801353915057L;

    private Long id ;

    private String displayName;

    private String tleFile;

    private Integer width;

    private Integer length;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTleFile() {
        return tleFile;
    }

    public void setTleFile(String tleFile) {
        this.tleFile = tleFile;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
