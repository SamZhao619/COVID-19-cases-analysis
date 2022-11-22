package comp1721.cwk1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CovidDataset {
    private List<CaseRecord> caseRecordlist;
    public CovidDataset() {
        caseRecordlist= new ArrayList<>();
    }
  // TODO: Write stub for size()
    public int size(){
        return caseRecordlist.size();
    }
    // TODO: Write stub for getRecord()
    public CaseRecord getRecord(int index){
        if(index>=0&&index<caseRecordlist.size()){
            CaseRecord caseRecord = caseRecordlist.get(index);
            return caseRecord;
        }else{
            throw new DatasetException("The index you provided is invalid");
        }
    }
  // TODO: Write stub for addRecord()
    public void addRecord(CaseRecord rec){
        caseRecordlist.add(rec);
    }
  // TODO: Write stub for dailyCasesOn()
    public CaseRecord  dailyCasesOn(LocalDate day){
        if(caseRecordlist.size()!=0){
            for (CaseRecord res : caseRecordlist) {
                if (res.getDate() == day) {
                    return  res;
                }
            }
        }
        throw new DatasetException("The given date caseRecord was not found");
    }
  // TODO: Write stub for readDailyCases()
    public void readDailyCases(String filename) throws IOException{
            //读取数据以前清空list
            caseRecordlist.clear();
            //从csv读取数据请存放到list表中
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            reader.readLine();
            String line = null;
            while((line=reader.readLine())!=null){
                String[] item = line.split(",");
                LocalDate date = LocalDate.parse(item[0]);
                int staffCases = Integer.parseInt(item[1]);
                int studentCases = Integer.parseInt(item[2]);
                int otherCases = Integer.parseInt(item[3]);
                CaseRecord caseRecord=new CaseRecord(date,staffCases,studentCases,otherCases);
                caseRecordlist.add(caseRecord);
            }
            reader.close();
    }

  // TODO: Write stub for writeActiveCases()
    public void writeActiveCases(String filename) throws IOException {
        if(caseRecordlist.size()<10){
            throw new DatasetException("The case data of the day is less than 10 days");
        }
        File csv = new File(filename);
        BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
        // 添加新的数据行
        bw.write("Date" + "," + "Staff" + "," + "Students"+ "," + "Other");
        //时统计前十天的数据
        int Staff=0;
        int Students=0;
        int Other=0;
        int index=0;
        for (int i = 0; i < caseRecordlist.size(); i++) {
            CaseRecord item = caseRecordlist.get(i);
            Staff += item.getStaffCases();
            Students += item.getStudentCases();
            Other += item.getOtherCases();
            bw.newLine();
            if(i>=9){
                bw.write( item.getDate()+ "," + Staff + "," +
                        Students+ "," +  Other);
                Staff-=caseRecordlist.get(index).getStaffCases();
                Students-=caseRecordlist.get(index).getStudentCases();
                Other-=caseRecordlist.get(index).getOtherCases();
                ++index;
            }else{
                bw.write( item.getDate()+ "," + item.getStaffCases() + "," +
                        item.getStudentCases()+ "," +  item.getOtherCases());
            }
        }
        //写入完成关闭流
        bw.close();
    }
}
