<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\MediatypeTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\MediatypeTable Test Case
 */
class MediatypeTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\MediatypeTable
     */
    public $Mediatype;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.mediatype'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('Mediatype') ? [] : ['className' => MediatypeTable::class];
        $this->Mediatype = TableRegistry::get('Mediatype', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->Mediatype);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
