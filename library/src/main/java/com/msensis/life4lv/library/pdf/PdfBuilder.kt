package com.msensis.life4lv.library.pdf

import android.content.Context
import android.graphics.*
import android.os.Environment
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream
import com.itextpdf.text.Paragraph
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.itextpdf.text.BaseColor
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfDocument
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.draw.LineSeparator
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 *  To use PDF builder use must insert textpdf library to your app grandle implementation "com.itextpdf:itextg:5.5.10"
 */
abstract class PdfBuilder<T: PdfBuilder<T>>(private var applicationContext: Context? = null) {

    private val family = BaseFont.createFont("assets/arialuni.ttf",  BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
    protected var header = Font(family, 24.toFloat(), Font.BOLD , BaseColor.BLACK)
    protected var small = Font(family, 14.toFloat(), Font.BOLD, BaseColor.BLACK)
    protected var normal = Font(family, 18.toFloat(), Font.NORMAL, BaseColor.BLACK)

    private val mHeadingFontSize = 20.0f
    private val mValueFontSize = 26.0f
    private val mColorAccent = BaseColor(0, 153, 204, 255)

    private var document: Document? = null
    private var author = "Msensis S.A."
    private var filename = "test-"

    protected fun getContext() = applicationContext!!

    fun filename(filename: String): T{
        this.filename = filename
        return this as T
    }

    fun author(filename: String): T{
        this.filename = filename
        return this as T
    }

    private fun createPdf(){
        document = Document()
        PdfWriter.getInstance(document, FileOutputStream(getPath()))
        document?.open()
        document?.pageSize = PageSize.A4
        document?.addCreationDate()
        document?.addAuthor(author)
    }


    fun build(){
        createPdf()
        buildTemplate(document!!)
        savePdf()
    }

    private fun savePdf(){
        document?.close()
        document = null
    }

    protected abstract fun buildTemplate(document: Document)


    protected fun paragraph(text: String, alignment: Int = Element.ALIGN_LEFT, font: Font = normal): Paragraph{
        val paragraph = Paragraph(text, font)
        paragraph.alignment = alignment
        return paragraph
    }

    protected fun phrase(text: String, font: Font = normal): Phrase{
        return Phrase(text, font)
    }

    protected fun paragraph(image: Image): Paragraph{
        val paragraph = Paragraph()
        paragraph.add(image)
        return paragraph
    }

    protected fun image( resource:Int, width: Int = 50, height: Int = 50, alignment: Int = Image.ALIGN_LEFT, color: String? = null): Image
    {
        val drawable = ContextCompat.getDrawable(getContext(), resource)
        val bitmap = getBitmap(drawable, width, height, color)

        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val image = Image.getInstance(stream.toByteArray())

        image.alignment = alignment
        return image
    }


    protected fun cell(text: String, alignment: Int = Element.ALIGN_LEFT, border: Int = Rectangle.BOX, font: Font = normal): PdfPCell{
        val cell = PdfPCell(Phrase(text, font))
        cell.horizontalAlignment = alignment
        cell.verticalAlignment = Element.ALIGN_MIDDLE
        cell.border = border

        return cell
    }

    protected fun cell(element: Element, alignment: Int = Element.ALIGN_LEFT, border: Int = Rectangle.BOX): PdfPCell{
        val cell = PdfPCell()
        cell.addElement(element)
        cell.horizontalAlignment = alignment
        cell.border = border

        return cell
    }

    protected fun addLineSeparator(){
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(0, 0, 0, 68)
        add(Chunk(lineSeparator))
    }

    protected fun addBreakLine(){
        add(Paragraph())
    }

    protected fun addText(text: String, alignment: Int = Element.ALIGN_LEFT, font: Font = normal){
        add(paragraph(text, alignment, font))
    }

    fun addImage(resource: Int, width: Int = 50, height: Int = 50, alignment: Int = Image.ALIGN_LEFT, color: String? = null)
    {
        add(image(resource, width, height, alignment, color))
    }

    protected fun add(element: Element) {
        document?.add(element)
    }

    private fun getBitmap(drawable: Drawable?, width: Int, height: Int, color: String? = null): Bitmap?
    {
        return try {
            val bitmap: Bitmap = Bitmap.createBitmap(
                width,
                height,
                Bitmap.Config.ARGB_8888
            )

            if(color != null)
                DrawableCompat.setTint(drawable!!, Color.parseColor(color))

            val canvas = Canvas(bitmap)
            drawable!!.setBounds(0, 0, canvas.width, canvas.height)
            drawable!!.draw(canvas)
            bitmap
        } catch (e: OutOfMemoryError) {
            // Handle the error
            null
        }

    }

    fun clear(){
        applicationContext = null
    }


    private fun getPath(): String
    {
        val directoryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path + "/"
        val file = File(directoryPath)
        if (!file.exists())
            file.mkdirs()

        val s = SimpleDateFormat("ddMMyyyyhhmmss")
        val format = s.format(Date())
        return "$directoryPath$filename-$format.pdf"
    }
}