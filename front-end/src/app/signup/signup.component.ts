import { Component, OnInit } from '@angular/core';
import { Signupclass } from '../classes/signupclass';
import { HttpClientModule ,HttpClient} from '@angular/common/http';
import { ToastrService } from "ngx-toastr";
import { Router } from "@angular/router";
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private http: HttpClient,private toast: ToastrService,private route: Router) { }


  public departments = ['CS','IT','AI','IS','MBA','MCA']
 signupData = new Signupclass("","","","","","","","")

onSignup()
{
  //console.log(this.signupData);
  let url = "http://localhost:8080/addStudent"
  this.http.post(url,this.signupData).subscribe(
 res=>{
    location.reload();
    console.log(res)
  }

);

this.toast.success("Sign Up Success..!","Message")
this.route.navigate(['/search'])
}

  ngOnInit() {
  }

}
