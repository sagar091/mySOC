package com.droidyme.mysoc.utility

import android.app.Activity
import android.app.DatePickerDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.annotation.NonNull
import androidx.core.text.HtmlCompat
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class Utility {

    companion object {

        // check internet connectivity
        // Returns connection type. 0: none; 1: mobile data; 2: wifi
        /*@Suppress("DEPRECATION")
        fun isInternetAvailable(context: Context): Boolean {

            val connectivity = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivity.allNetworkInfo
            for (value in info) if (value.state == NetworkInfo.State.CONNECTED) {
                return true
            }
            return false
        }*/

        // showing no internet alert
        /*fun noInternetAlert(context: Context) {
            CustomAlertDialog.newInstance(context.getString(R.string.no_internet),
                context.getString(R.string.no_internet_msg),
                context.getString(R.string.option_ok),
                null,
                object : CustomAlertDialog.DialogOptionsListener {
                    override fun onClickPositive(dialog: Dialog?) {
                        dialog?.dismiss()
                    }

                    override fun onClickNegative(dialog: Dialog?) {

                    }

                })
                .show((context as AppCompatActivity).supportFragmentManager, CustomAlertDialog.TAG)
        }*/

        // run-time permission, example is in usage file
        fun askPermissions(
            context: Context,
            @NonNull permissions: Array<String>,
            permissionListener: PermissionListener?
        ) {

            if (permissions.isEmpty() && permissionListener != null) {
                return
            }

            TedPermission.with(context)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(*permissions)
                .check()
        }

        // changing date-time formatting
        fun formatDate(date: String?, inputFormat: String?, outputFormat: String?): String {
            var result = ""
            var inputSDF: SimpleDateFormat?
            var outputSDF: SimpleDateFormat?
            try {
                inputSDF = SimpleDateFormat(inputFormat, Locale.US)
                outputSDF = SimpleDateFormat(outputFormat, Locale.US)
                result = outputSDF.format(inputSDF.parse(date))
            } catch (e: Exception) {
                e.printStackTrace()
                return ""
            } finally {
                inputSDF = null
                outputSDF = null
            }
            return result
        }

        // get date/time formatted string from calendar object
        fun getFormattedDateTime(calendar: Calendar, outputFormat: String?): String {
            val sdf = SimpleDateFormat(outputFormat, Locale.US)
            return sdf.format(calendar.time)
        }

        // get current date-time in specific format, timZone is optional.. can keep blank or null
        fun getCurrentDateAndTime(outputFormat: String, timeZone: String?): String? {
            val c = Calendar.getInstance()
            val df = SimpleDateFormat(outputFormat, Locale.US)
            if (!isNullOrEmpty(timeZone)) {
                df.timeZone = TimeZone.getTimeZone(timeZone)
            }
            return df.format(c.time)
        }

        // check null/empty/blank/NA value
        fun isNullOrEmpty(string: String?): Boolean {
            return string == null || string == "" || string == " " || string == "N/A" || string ==
                    "n/a" || string == "NA" || string == "na"
        }

        // open app on play store
        fun openApp(context: Context) {
            val appPackageName = context.packageName

            try {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (exce: ActivityNotFoundException) {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
            (context as Activity).overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
        }

        // clear session, called on logout
        /*fun clearSession(context: Context) {
            PrefUtils.logout(context)
            context.fireIntent(MainActivity::class.java, true)
        }*/

        // clear everything, called on delete account
        /*fun deleteUserData(context: Context) {
            PrefUtils.clearAll(context)
            context.fireIntent(SplashActivity::class.java, true)
        }*/

        // get user_agent
        fun getUserAgent(context: Context): String {
            val device = Build.DEVICE
            val platform = "Android"
            var version = ""
            var userAgent = ""

            val manager: PackageManager = context.packageManager
            val info: PackageInfo

            try {
                info = manager.getPackageInfo(context.packageName, 0)
                version = info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            userAgent = "$device;$platform $version"
            return userAgent
        }

        // create temp file at Android/data/com.paysme.cabappdriver/files/Pictures
        @Throws(IOException::class)
        fun createImageFile(context: Context): File {
            // Create an image file name
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val imageFileName = "PNG_" + timeStamp + "_"
            val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val image = File.createTempFile(
                imageFileName, /* prefix */
                ".png", /* suffix */
                storageDir      /* directory */
            )

            // Save a file: path for use with ACTION_VIEW intents
            // image.absolutePath
            return image
        }

        // Convert Uri to File
        fun uriToImageFile(context: Context, uri: Uri): File? {
            val filePathColumn = arrayOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())
            val cursor = context.contentResolver?.query(uri, filePathColumn, null, null, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                    val filePath = cursor.getString(columnIndex)
                    cursor.close()
                    return File(filePath)
                }
                cursor.close()
            }
            return null
        }

        // Copy InputStream data to a File
        @Throws(IOException::class)
        fun copyInputStreamToFile(inputStream: InputStream, file: File) {

            // append = false
            FileOutputStream(file, false).use { outputStream ->
                var read: Int
                val bytes = ByteArray(DEFAULT_BUFFER_SIZE)
                while (inputStream.read(bytes).also { read = it } != -1) {
                    outputStream.write(bytes, 0, read)
                }
            }
        }

        // show developer required info
        /*fun showDevInfo(context: Context) {
            val id = PrefUtils.getProfile(context).data.user_id
            val credentials = PrefUtils.getCredentials(context)
            val appType = BuildConfig.FLAVOR + "_" + BuildConfig.BUILD_TYPE
            var installedAppVersion: String? = null

            val manager = context.packageManager
            val info: PackageInfo
            try {
                info = manager.getPackageInfo(context.packageName, 0)
                installedAppVersion = info.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            val stringToShow =
                "User_Id: $id " +
                        "\nCredentials: ${credentials.email} - ${credentials.password} " +
                        "\nApp_Type: $appType " +
                        "\nVersion: $installedAppVersion"

            CustomAlertDialog.newInstance(null, stringToShow, "OK", null,
                object : CustomAlertDialog.DialogOptionsListener {
                    override fun onClickPositive(dialog: Dialog?) {
                        dialog?.dismiss()
                    }

                    override fun onClickNegative(dialog: Dialog?) {
                        // not required
                    }

                })
                .show((context as AppCompatActivity).supportFragmentManager, CustomAlertDialog.TAG)
        }*/

        fun getCurrencySymbol(context: Context, currencySymbol: String): String {
            return if (!isNullOrEmpty(currencySymbol))
                HtmlCompat.fromHtml(currencySymbol, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    .toString()
            else
                "£"
        }

        fun priceDisplayFormat(): DecimalFormat {
            return DecimalFormat("0.00")
        }

        // show normal info dialog
        /*fun showInfoDialog(context: Context, info: String) {
            CustomAlertDialog.newInstance(null, info, "OK", null,
                object : CustomAlertDialog.DialogOptionsListener {
                    override fun onClickPositive(dialog: Dialog?) {
                        dialog?.dismiss()
                    }

                    override fun onClickNegative(dialog: Dialog?) {
                        // not required
                    }

                })
                .show((context as AppCompatActivity).supportFragmentManager, CustomAlertDialog.TAG)
        }*/

        fun roundOffDecimal(number: Double): Double {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.FLOOR
            return df.format(number).toDouble()
        }

        // open web url using intent
        fun openIntentUrl(context: Context, url: String) {
            try {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                    ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // open dial pad for call
        fun openDialPad(context: Context, mobileNumber: String) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $mobileNumber")
            context.startActivity(intent)
        }

        // bitmap from vector drawable
        /*fun bitmapFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
            // below line is use to generate a drawable.
            val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)

            // below line is use to set bounds to our vector drawable.
            vectorDrawable!!.setBounds(
                0,
                0,
                vectorDrawable.intrinsicWidth,
                vectorDrawable.intrinsicHeight
            )

            // below line is use to create a bitmap for our
            // drawable which we have added.
            val bitmap = Bitmap.createBitmap(
                vectorDrawable.intrinsicWidth,
                vectorDrawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )

            // below line is use to add bitmap in our canvas.
            val canvas = Canvas(bitmap)

            // below line is use to draw our
            // vector drawable in canvas.
            vectorDrawable.draw(canvas)

            // after generating our bitmap we are returning our bitmap.
            return BitmapDescriptorFactory.fromBitmap(bitmap)
        }*/

        fun selectDate(context: Context): String {
            var selectedDate = ""
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(
                context,
                { view, year, monthOfYear, dayOfMonth ->
                    selectedDate = "" + dayOfMonth + " " + (monthOfYear + 1) + ", " + year
                },
                year,
                month,
                day
            )
            dpd.datePicker.maxDate = Calendar.getInstance().timeInMillis
            dpd.show()

            return selectedDate
        }
    }
}