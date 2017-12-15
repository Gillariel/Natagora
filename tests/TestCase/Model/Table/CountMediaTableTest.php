<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountMediaTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountMediaTable Test Case
 */
class CountMediaTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountMediaTable
     */
    public $CountMedia;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_media'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountMedia') ? [] : ['className' => CountMediaTable::class];
        $this->CountMedia = TableRegistry::get('CountMedia', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountMedia);

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
