export interface Customer {
    customerID: number,
    customerName: {
        fname: string,
        lname: string
    },
    gender: string,
    password: string,
    email: string,
    dateOfBirth: number,
    phone: number,
    address: {
        doorno: number,
        street: string,
        city: string,
        pincode: number
    }
}