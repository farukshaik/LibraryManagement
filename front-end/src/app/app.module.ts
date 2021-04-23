import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormGroup,ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { ToastrModule } from "ngx-toastr";
import { HttpClientModule, HttpClient } from "@angular/common/http";
import { ApiserviceService } from "./services/apiservice.service";
import { SignupComponent } from './signup/signup.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { SigninComponent } from './signin/signin.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { LibrarysigninComponent } from './librarysignin/librarysignin.component';
import { LibdashboardComponent } from './libdashboard/libdashboard.component';
import { IssuebookComponent } from './issuebook/issuebook.component';
import { LibissuebookComponent } from './libissuebook/libissuebook.component';
import { LibrenewbookComponent } from './librenewbook/librenewbook.component';
import { LibsubmitbookComponent } from './libsubmitbook/libsubmitbook.component';

@NgModule({
  declarations: [
    SignupComponent,
    AppComponent,
    SearchbookComponent,
    SigninComponent,
    UserdashboardComponent,
    MainpageComponent,
    LibrarysigninComponent,
    LibdashboardComponent,
    IssuebookComponent,
    LibissuebookComponent,
    LibrenewbookComponent,
    LibsubmitbookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [ApiserviceService,AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
