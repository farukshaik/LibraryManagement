import { Component, OnInit } from '@angular/core';
import { Signinclass } from "../classes/signinclass";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { Router,ActivatedRoute } from "@angular/router";
import { ToastrService, Toast } from "ngx-toastr";
import { HttpParams } from "@angular/common/http";
import { FormGroup,FormControl,Validators } from "@angular/forms";
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  form:any;
  constructor(private http:HttpClient, private route: Router,private toast: ToastrService,private activatedRouter: ActivatedRoute) { 
    this.form = new FormGroup({
      rollNo:new FormControl("",Validators.required),
      password:new FormControl("",Validators.required),
      
})
}

rollNo:''
password:''
verified  = false
onSignIn()
  {
   
    let data:any = this.form.value
    let url = "http://localhost:8080/authenticate"
    const payload = new HttpParams()
    .set('username', data.rollNo+'$'+'student')
     .set('password', data.password);
  
  this.http.post(url, payload).subscribe({

     next: res=>{
       console.log(res.msg)
       if(res.msg === 'success')
       {
       this.toast.success("Sign In Success..!","Message")
       this.route.navigate(['/userdashboard'],{

       queryParams:{data:btoa(JSON.stringify(data))}
      })
    }
    else {
      this.toast.warning("Invalid Credentials..!","Warning")
    } 
  }

    
  });
  
  }
/*
onSignIn()
{
  let url = "http://localhost:8080/authenticate"
  this.http.post(url,this.signinData).subscribe({
    next: res=> {
      location.reload()
    }
  });
  this.toast.success("Sign In Success..!","Message")
  this.route.navigate(['/userdashboard'])
}
*/
  ngOnInit() {
  }

}
