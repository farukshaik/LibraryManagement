import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from "../services/apiservice.service";
import { Signupclass } from '../classes/signupclass';
import { ToastrService, Toast } from "ngx-toastr";
import { HttpParams, HttpClient } from '@angular/common/http';
import {  Issuebook } from "../classes/issuebook";
import { Updaterankclass } from "../classes/updaterankclass";
import {Router,ActivatedRoute } from "@angular/router";
import { CompileShallowModuleMetadata } from '@angular/compiler';
@Component({
  selector: 'app-libissuebook',
  templateUrl: './libissuebook.component.html',
  styleUrls: ['./libissuebook.component.css']
})
export class LibissuebookComponent implements OnInit {

  constructor(private _api: ApiserviceService,private activeroute:ActivatedRoute, private route:Router,private toast:ToastrService,private http:HttpClient) { }

  studentDetails:Signupclass[]
  issueBook = new Issuebook('','')
  updateRank = new Updaterankclass('')
  continue =  false
  rollNo:''
  rollNumber:''
  roll:''
  rank:''
  ISBN:''
  proceed:boolean = false

  onSubmit(rollNumber)
  { 
    this.continue = true
    this._api.getStudentData(this.rollNumber).subscribe(
      data=>
      {
      this.studentDetails = data;
      });
  }
  
  onProceed()
  {
    if (this.studentDetails.rank == 3) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
      this.toast.error("Not eligible to borrow books for 1 month","Error")
    }
     
    if (this.studentDetails.rank == 2) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
      this.toast.error("Not eligible to borrow books for 2 months","Error")
    }
  
    if (this.studentDetails.rank == 1) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
      this.toast.error("Not eligible to borrow books for 3 months","Error")
    }
  
    if(this.studentDetails.rank == 4)
    {
       this.ISBN = prompt("Enter ISBN number: ")
       this.toast.success("Book issued successfully ..!","Mesaage")
    }
    if(this.studentDetails.rank == 5)
    {
      this.ISBN =  prompt("Enter ISBN number: ")
      this.toast.success("Book issued suuceesfully..!","Success")
    }
  
    this.issueBook.rollNumber = this.studentDetails.rollNo
    this.issueBook.isbn = this.ISBN
console.log(this.issueBook)
    if(this.issueBook.isbn != undefined)
    {
   let url = "http://localhost:8080/issueBook"
  
   this.http.post(url,this.issueBook).subscribe(
     res=>
     {
       console.log(res)
     }
   )
    }
   this.route.navigate(['/libdashboard'])
  }
  
  onUpdateRank(rollNumber)
  {
    this.proceed = true
    
  let url = "http://localhost:8080/updateRank"

  this.http.post(url,rollNumber).subscribe(
    response=>
    {
      console.log(response)
    }
  )
    
    alert("Rank updated successfully..!")
    //window.location.reload()
  }
  
  

  ngOnInit() {
    this.activeroute.queryParams.subscribe((params)=>{
      this.rollNumber = JSON.parse(atob(params.rollNumber))
      this.onSubmit(this.rollNumber)
    })

  }

}
