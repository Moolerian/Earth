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

    private Long width;

    private Long length;


    public Satellite(Long id , String displayName, String tleFile, Long width, Long length) {
        this.id = id;
        this.displayName = displayName;
        this.tleFile = tleFile;
        this.width = width;
        this.length = length;
    }

    public Satellite() {
    }

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

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
