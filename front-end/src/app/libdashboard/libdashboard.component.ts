import { Component,OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ToastrService, Toast } from "ngx-toastr";
@Component({
  selector: 'app-libdashboard',
  templateUrl: './libdashboard.component.html',
  styleUrls: ['./libdashboard.component.css']
})

export class LibdashboardComponent  {

constructor(private route:Router,private toast:ToastrService){}

onLogOut()
{
  this.toast.success("Log Out Success...!","Message")
  this.route.navigate(['/librarysignin'])
}


onSubmit(rollNumber)
{
 // console.log(rollNumber)
  this.route.navigate(['/libissuebook'],{queryParams:{rollNumber:btoa(JSON.stringify(rollNumber))}
})
}

onRenewOrSubmit(rollNumber)
{
   this.route.navigate(['/librenewbook'],{queryParams:{rollNumber:btoa(JSON.stringify(rollNumber))}
})
}
  ngOnInit(){
  }

}
