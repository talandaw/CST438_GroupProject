import unittest
from django.contrib import auth


class Test_Site(unittest.TestCase):

    #checks for valid format of email given
    def check_email(mail):
        subMail, domain = mail.split('@',1)
        if len(subMail) <= 128 and len(domain) < 256:
            assert False;

    # checks if the user was successfully logged in to django client db
    def userLoggedIn(self):
        user = auth.get_user(self.client)
        assert user.is_authenticated()

    #more tests future created by following documentation at
    #https://docs.djangoproject.com/en/2.0/topics/testing/overview/


if __name__ == '__main__':
    unittest.main()
