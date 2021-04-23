import { Injectable } from '@angular/core';
import { HttpClient ,HttpParams} from "@angular/common/http";
import { Observable } from 'rxjs';
import { DataClass } from "../classes/data-class";

@Injectable({
  providedIn: 'root'
})

export class ApiserviceService {

  constructor(private httpclient: HttpClient) { }

  getData(bookName):Observable<any>{

    let param1 = new HttpParams().set("bookName",bookName)
    return this.httpclient.get("http://localhost:8080/getBookDetailsByName",{params:param1}) 

  }

  getStudentData(rollNumber):Observable<any>{
    let param2 = new HttpParams().set("rollNumber",rollNumber)
    //console.log(param2)
    return this.httpclient.get("http://localhost:8080/getStudentData",{params:param2});
  }


  issueBook(rollNumber,ISBN):Observable<any>{
    let param4 = new HttpParams().set("rollNumber",rollNumber)
    let param3 = new HttpParams().set("isbn",ISBN)
    console.log(param3,param4)
    return this.httpclient.post("http://localhost:8080/issueBook",{params:param3},{params:param4})
  }

  getBookDetails(rollNumber):Observable<any>{
    let param5 = new HttpParams().set("rollNumber",rollNumber)
    return this.httpclient.get("http://localhost:8080/getBooks",{params:param5})
  }


  onRenewal(transId):Observable<any>
  {
    let param6 = new HttpParams().set("transId",transId)
    return this.httpclient.get("http://localhost:8080/renewBook",{params:param6})
  } 
  onRenewalByLib(transId):Observable<any>
  {
    let param7 = new HttpParams().set("transId",transId)
    return this.httpclient.get("http://localhost:8080/libRenewBook",{params:param7})
  }

  onSubmitByLib(transId):Observable<any>{
    let param8 = new HttpParams().set("transId",transId)
    return this.httpclient.get("http://localhost:8080/libSubmitBook",{params:param8})
  }

  onUpdate(rollNumber):Observable<any>{
    let param9 = new HttpParams().set("rollNumber",rollNumber)
    console.log(param9)
    return this.httpclient.post("http://localhost:8080/updateRank",{params:param9})
  }
}
