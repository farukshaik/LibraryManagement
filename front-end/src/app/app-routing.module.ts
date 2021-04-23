import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from "./signup/signup.component";
import { SearchbookComponent } from "./searchbook/searchbook.component";
import { SigninComponent } from "./signin/signin.component";
import { UserdashboardComponent } from "./userdashboard/userdashboard.component";
import { MainpageComponent } from "./mainpage/mainpage.component";
import { LibrarysigninComponent } from './librarysignin/librarysignin.component';
import { LibdashboardComponent } from "./libdashboard/libdashboard.component";
import { LibissuebookComponent } from './libissuebook/libissuebook.component';
import { LibrenewbookComponent } from "./librenewbook/librenewbook.component";
import { LibsubmitbookComponent } from "./libsubmitbook/libsubmitbook.component";
import { combineLatest } from 'rxjs';
import { componentFactoryName } from '@angular/compiler';
const routes: Routes = [
  {
    path: '', pathMatch: 'full', component: MainpageComponent
  },
{
  path: 'signup', component: SignupComponent
},
{
  path: 'search', component: SearchbookComponent
},
{
  path: 'signin', component: SigninComponent
},
{
  path: 'userdashboard', component: UserdashboardComponent
},
{
  path: 'librarysignin', component: LibrarysigninComponent
},
{
  path: 'libdashboard', component: LibdashboardComponent
},
{
  path: 'libissuebook', component: LibissuebookComponent
},
{
  path: 'librenewbook', component: LibrenewbookComponent
},
{
  path: 'libsubmitbook', component: LibsubmitbookComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
