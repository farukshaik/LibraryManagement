import { Component, OnInit } from '@angular/core';
import { Librarysignin } from "../classes/librarysignin";
import { Router } from "@angular/router";
import { HttpParams, HttpClient } from "@angular/common/http";
import { ToastrService, Toast } from "ngx-toastr";
import { FormGroup,FormControl,Validators } from "@angular/forms";
@Component({
  selector: 'app-librarysignin',
  templateUrl: './librarysignin.component.html',
  styleUrls: ['./librarysignin.component.css']
})
export class LibrarysigninComponent  {


  form:any;
  constructor(private http:HttpClient, private route: Router,private toast: ToastrService) { 
    this.form = new FormGroup({
      empId:new FormControl("",Validators.required),
      password:new FormControl("",Validators.required),
      
})
}
  librarysigninData = new Librarysignin("","")
msg:''
  // constructor(private route: Router,private http: HttpClient,private toast:ToastrService) { }

onSignIn()
{
  let data:any = this.form.value
    let url = "http://localhost:8080/authenticate"
    const payload = new HttpParams()
    .set('username', data.empId+'$'+'librarian')
    .set('password', data.password);
  

    console.log(payload)
  this.http.post(url, payload).subscribe({

     next: res=>{
       console.log(res.msg)
       if(res.msg === 'success')
       {
       this.toast.success("Sign In Success..!","Message")
       this.route.navigate(['/libdashboard'])
    }
    else {
      this.toast.warning("Invalid Credentials..!","Warning")
    } 
  }

    
  });
  
  //console.log(this.librarysigninData)
  //this.route.navigate(['/libdashboard'])
}

  ngOnInit() {
  }

}
