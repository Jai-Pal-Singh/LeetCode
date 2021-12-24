package test.practice;

import java.io.RandomAccessFile;

public class Dictionary {

    public Response findAddress(String name, String[] fileNames) {

        for (String file : fileNames) {
            try (RandomAccessFile fis = new RandomAccessFile(file, "r")) {
                String prevName = "";
                while (fis.getFilePointer() < fis.length()) {
                    String line = fis.readLine();

                    // Name| phone| address
                    String[] data = line.split("[|*]");
                    if (name.equalsIgnoreCase(data[0])) {
                        Response resp = new Response();
                        resp.setDataFound(true);
                        resp.setFileName(file);
                        resp.setName(data[0]);
                        resp.setPhone(data[1]);
                        resp.setAddress(data[1]);
                        return resp;
                    } else {
                        int pos1 = name.compareTo(prevName);
                        int pos2 = name.compareTo(data[0]);
                        if (pos1 * pos2 < 0) {
                            Response resp = new Response();
                            resp.setDataFound(false);
                            resp.setFileName(file);
                            return resp;
                        }
                        prevName = data[0];
                    }

                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        return null;

    }
}

class Response {
    private boolean dataFound;
    private String fileName;
    private String name;
    private String phone;
    private String address;

    public boolean isDataFound() {
        return dataFound;
    }

    public void setDataFound(boolean dataFound) {
        this.dataFound = dataFound;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
